package ua.com.restapi.models;

public class ResponseUserModel {
  private String fio;

  public String getFio() {
    return fio;
  }

  public void setFio(String fio) {
    this.fio = fio;
  }

  @Override
  public String toString() {
    return "{\"fio\": \"" + getFio() + "\"}";
  }
}
