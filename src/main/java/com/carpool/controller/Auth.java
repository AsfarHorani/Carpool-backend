package com.carpool.controller;

import com.carpool.config.JwtTokenUtil;
import com.carpool.dto.JwtRequest;
import com.carpool.dto.JwtResponse;
import com.carpool.dto.UserDto;
import com.carpool.dto.UserDtoResponse;
import com.carpool.service.JwtUserDetailsService;
import com.carpool.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;
@RestController
@CrossOrigin
public class Auth {

//	@Autowired
//	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		//authenticationRequest.setPassword("user");
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getAddress());
		//this is not password this is basically nonce, remeber we are not using password
		String message = "Nonce: "+userDetails.getPassword();
		System.out.println(message);
		message="Hello World";
		verifySignature(authenticationRequest.getAddress(),authenticationRequest.getSignedMessage(),message);
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto userdto) throws Exception {
		User user = userDetailsService.save(userdto);
		UserDtoResponse udr = new UserDtoResponse();
		udr.setId(user.getId());
		udr.setAddress(user.getUsername());
		return ResponseEntity.ok(udr);
	}


	
	/**
	 * Internal utility method on servers side. You can do extract things after the both keys are matched.
	 * @param address
	 * @param signedMessage
	 * @param originalMessage
	 * @throws SignatureException
	 */
	public static boolean verifySignature(String address, String signedMessage, String originalMessage)
			throws Exception {

		String decryptedAddress = getAddressUsedToSignHashedPrefixedMessage(signedMessage, originalMessage);
		decryptedAddress = "0x" + decryptedAddress;
		System.out.println("Address :          " + address);
		System.out.println("decryptedAddress : " + decryptedAddress);
		// val messageHashBytes = Numeric.hexStringToByteArray(messageHashed)
		
		if(address.equals(decryptedAddress)) {
			// if verification successfull, you can build other business logic here.
			System.out.println("Signature Verified");
			return true;
		} else {
			System.err.println("Signature Verified Failed");
			throw new Exception("Signature Verified Failed");
		}
	}

	/**
	 * This method using web3j api to retrieve the address which is used for singing the originalMessage.
	 * 
	 * @param signedHash hashed messages which was generated by hashing the originalMessage.
	 *        in MVC framework scenarios, the client application requests the any Crypto Provider (Like Metamask) to sign the message.
	 *        Once signed the messages you will get signedHash. This signedHash will be sent to the server for verification (can be used as authenticating the user account).
	 * 
	 * @param originalMessage the message which client requests Crypto provider for Signing it.
	 * 
	 * @return
	 * @throws SignatureException
	 */
	private static String getAddressUsedToSignHashedPrefixedMessage(String signedHash, String originalMessage)
			throws Exception {

		String r = signedHash.substring(0, 66);
		String s = "0x" + signedHash.substring(66, 130);
		String v = "0x" + signedHash.substring(130, 132);
		
		String pubkey = Sign.signedPrefixedMessageToKey(originalMessage.getBytes(), new Sign.SignatureData(
				Numeric.hexStringToByteArray(v)[0], Numeric.hexStringToByteArray(r), Numeric.hexStringToByteArray(s)))
				.toString(16);

		return Keys.getAddress(pubkey);
	}
	
	

}
