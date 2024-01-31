package com.itvedant.petstore123.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
        // @Autowired
    // private UserService userService;

    // //crud operation

    // //creating
    // //? indicates response  that can be of any type
    //  @PostMapping("/users")
    // public ResponseEntity<?> add(@RequestBody @Valid user u){
    //     return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(u));
    // }
    
    // //reading

    // @GetMapping("/users") //for all ID reading purpose
    // public ResponseEntity<?> getUsers(){
    //     return ResponseEntity.ok().body(userService.getAllUsers());

    // }
    // @GetMapping("/users/{id}") //search by only ID
    // public ResponseEntity<?> getusers(@PathVariable Integer id){
    //     user found = userService.getUserById(id);
    //     if(found == null) {
    //         return ResponseEntity.badRequest().body("user with this id does not exists");
    //     }
    //     else{
    //         return ResponseEntity.ok().body(found);
    //     }


    // }

    // //updating
    // @PutMapping("/users/{id}")
    // public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody user u){
    //     user found = userService.getUserById(id);
    //      if(found == null) {
    //         return ResponseEntity.badRequest().body("user with this id does not exists");
    //     }
    //     else{
    //         return ResponseEntity.ok().body(userService.updatedUser(id,u));
    //     }
    // }

    //     //delete

    //      @DeleteMapping("/users/{id}")
    //       public ResponseEntity<?> delete(@PathVariable Integer id){
    //         user found = userService.getUserById(id);
    //      if(found == null) {
    //         return ResponseEntity.badRequest().body("user with this id does not exists");
    //     }
    //     else{
    //         return ResponseEntity.ok().body(userService.deleteUser(id));
    //     }


    //       }
        
}

