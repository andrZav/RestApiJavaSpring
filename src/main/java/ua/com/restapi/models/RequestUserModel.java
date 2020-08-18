package ua.com.restapi.models;

public class RequestUserModel {
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "{\"id\": " + getId() + "}";
  }
}
