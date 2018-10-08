package pl.szotaa.dictrr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class StorageService {

    private final Map<String, String> storage = new HashMap<>();

    public String get(String key){
        return storage.get(key);
    }

    public void set(String key, String value){
        storage.put(key, value);
    }
}
