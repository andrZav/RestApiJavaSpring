package ua.com.restapi.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.restapi.models.RequestUserModel;
import ua.com.restapi.models.ResponseUserModel;
import ua.com.restapi.service.GetUserDataService;

@RestController
public class RetrieveUserData {
  @Autowired
  private GetUserDataService getUserDataService;

  @RequestMapping(value = "/getUser", method = RequestMethod.POST)
  @ResponseBody
  public ResponseUserModel responseUsersData(@RequestBody RequestUserModel requestUserModel) {
    return getUserDataService.retrieveData(requestUserModel);
  }
}
