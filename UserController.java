package org.example.Controller;

import org.example.Entity.UserEntity;

import org.example.Service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
    @RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public class UserController {
    UserEntity userEntity;
    private final UserService userService;
    public UserController(UserService userService) {
            this.userService = userService;
        }
        @GetMapping(value = "balance/id/{id}")
        public Optional<UserEntity> getBalance(@PathVariable("id") Long ID) throws Exception {
            return userService.getBalanceAndID(ID);
            }

        @PutMapping(value = "putMoney/putSum/{putSum}/id/{id}")
        public int putMoney(@PathVariable("id") Long ID,@PathVariable("putSum") int putSum){
        userService.putMoneyAndBalance(ID, putSum);
        return 1;
        }
        @PutMapping(value = "takeMoney/takeSum/{takeSum}/id/{id}")
        public int takeMoney(@PathVariable("id") Long ID,@PathVariable("takeSum") int takeSum) {
            while (true){
            userService.takeMoneyAndBalance(ID, takeSum);
            return 1;
        }
        }
}
