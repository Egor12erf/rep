package org.example.Service;

import org.example.Entity.UserEntity;
import org.example.Repository.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final Repository repository;

    public UserService(Repository repository) {
        this.repository = repository;
    }

    public Optional<UserEntity> getBalanceAndID(Long ID)throws Exception {
        try {
            return repository.findById(ID);
        } catch (Exception e){
            throw new Exception("Ошибка при выполнении операции");
        }
    }

    public void putMoneyAndBalance(Long ID, int putSum){
            UserEntity userEntity = repository.findById(ID).get();
            userEntity.setBalance(userEntity.Balance + putSum);
            repository.save(userEntity);
    }

    public int takeMoneyAndBalance(Long ID, int takeSum) {
                UserEntity userEntity = repository.findById(ID).get();
                if (userEntity.getBalance(userEntity.getID(ID)) > takeSum){
                    userEntity.setBalance(userEntity.Balance - takeSum);
                    repository.save(userEntity);
                    return 1;
                }
                else{
                return 0;
                }
    }
    }
