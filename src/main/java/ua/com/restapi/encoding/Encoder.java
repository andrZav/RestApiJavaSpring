package ua.com.restapi.encoding;

public interface Encoder {
  String encode(String rawMessage) throws Exception;
  String decode(String encodedMessage) throws Exception;
}
