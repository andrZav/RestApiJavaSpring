package ua.com.restapi.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.com.restapi.encoding.Encoder;
import ua.com.restapi.endpoints.RetrieveUserData;
import ua.com.restapi.infrastructure.logger.FileLogger;
import ua.com.restapi.models.RequestUserModel;
import ua.com.restapi.models.ResponseUserModel;
import ua.com.restapi.service.GetUserDataService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class GetUserDataServiceImpl implements GetUserDataService {
  private static final Logger logger = Logger.getLogger(RetrieveUserData.class);
  private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private String serverTime;
  private final static String USERS_FIO = "Test Testov";

  @Autowired
  private FileLogger fileLogger;

  @Autowired
  private Encoder encoder;

  @Override
  public ResponseUserModel retrieveData(RequestUserModel requestUserModel) {
    try {
      // date time of request/response
      serverTime = simpleDateFormat.format(new Date());

      fileLogger.write(String.format("%s %s\r", serverTime, requestUserModel.toString()));

      String encIn = encoder.encode(requestUserModel.toString());
      logger.info("=== encryption " + encIn);
      logger.info("=== decryption " + encoder.decode(encIn));
    } catch (Exception e) {
      logger.error("Error during API request: " + e);
      e.printStackTrace();
    }

    if (requestUserModel.getId() != 1) {
      logger.info("Input request contains no proper ID. id= " + requestUserModel.getId());
      return null;
    }

    // response
    ResponseUserModel responseUserModel = new ResponseUserModel();
    responseUserModel.setFio(USERS_FIO);

    try {
      fileLogger.write(String.format("%s %s\r", serverTime, responseUserModel.toString()));

      String encOut = encoder.encode(responseUserModel.toString());
      logger.info("=== encryption " + encOut);
      logger.info("=== decryption " + encoder.decode(encOut));
    } catch (Exception e) {
      logger.error("Error during API request: " + e);
      e.printStackTrace();
    }

    return responseUserModel;
  }
}
