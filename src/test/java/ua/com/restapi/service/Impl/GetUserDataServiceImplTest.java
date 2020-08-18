package ua.com.restapi.service.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.restapi.models.RequestUserModel;
import ua.com.restapi.service.GetUserDataService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class GetUserDataServiceImplTest {
  private final String response = "{\"fio\": \"Test Testov\"}";
  private RequestUserModel requestUserModelPositive;
  private RequestUserModel requestUserModelWrongInput;

  @Autowired
  private GetUserDataService getUserDataService;

  @BeforeEach
  void setUp() {
    requestUserModelPositive = new RequestUserModel();
    requestUserModelPositive.setId(1);

    requestUserModelWrongInput = new RequestUserModel();
    requestUserModelWrongInput.setId(2);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void retrieveData() {
    assertEquals(response, getUserDataService.retrieveData(requestUserModelPositive).toString());
    assertNull (getUserDataService.retrieveData(requestUserModelWrongInput));
  }
}