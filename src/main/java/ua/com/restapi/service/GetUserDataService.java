package ua.com.restapi.service;

import ua.com.restapi.models.RequestUserModel;
import ua.com.restapi.models.ResponseUserModel;

public interface GetUserDataService {
  ResponseUserModel retrieveData(RequestUserModel requestUserModel);
}
