package app.service;

import app.model.Log;
import app.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface LogService {

    void addLog(Log log);

    List<Log> getAllLogs();
}
