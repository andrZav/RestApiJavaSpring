package ua.com.restapi.infrastructure.logger.Impl;

import org.springframework.stereotype.Repository;
import ua.com.restapi.infrastructure.logger.FileLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@Repository
public class FileLoggerImpl implements FileLogger {
  @Override
  public void write(String data) {
    File logDir = new File(LOG_API_DIR);
    if (!logDir.exists()) {
      logDir.mkdirs();
    }
    try (BufferedWriter b = new BufferedWriter(new FileWriter(logDir + File.separator + LOG_API_FILENAME, true))) {
      b.append(data);
      b.flush();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
