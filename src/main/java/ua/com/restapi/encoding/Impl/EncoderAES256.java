package ua.com.restapi.encoding.Impl;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Component;
import ua.com.restapi.encoding.Encoder;

import java.security.NoSuchAlgorithmException;

@Component
public class EncoderAES256 implements Encoder {
  private static final Logger logger = Logger.getLogger(EncoderAES256.class);

  private final CharSequence encoderPassword = "Pass12345";
  private static TextEncryptor encryptor = null;

  public EncoderAES256() {
    try {
      init();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      logger.error("Error during encoder init.Exception: " + e);
    }
  }

  private void init() throws NoSuchAlgorithmException  {
    CharSequence salt = KeyGenerators.string().generateKey();
    encryptor = Encryptors.text(encoderPassword, salt);
    logger.info("Init encoding instance");
  }

  @Override
  public String encode(String rawMessage) {
    String result = null;
    try {
      result = encryptor.encrypt(rawMessage);
      logger.info("Encrypting data: " + rawMessage);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Encrypting data error.Exception: " + e);
    }
    return result;
  }

  @Override
  public String decode(String encodedMessage) {
    String result = null;
    try {
      result = encryptor.decrypt(encodedMessage);
      logger.info("Decrypting data: " + encodedMessage);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Decrypting data error.Exception: " + e);
    }
    return result;
  }
}
