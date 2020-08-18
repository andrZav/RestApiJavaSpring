package ua.com.restapi.infrastructure.logger;

public interface FileLogger {
  String LOG_API_DIR = System.getProperty("catalina.home") + "\\webapps\\ROOT\\Users\\logs";
  String LOG_API_FILENAME = "log.txt";
  void write(String data);
}
