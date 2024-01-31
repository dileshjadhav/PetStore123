package com.itvedant.petstore123.Controller;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController//string data automatically covert into json format @controller=url is mapped with the method. & @responsebody convert json format.
public class PrductController {
    @Autowired //object is already created in services bring that object from services and provided to the infront.reference variable.
    private com.itvedant.petstore123.Services.ProductService productService;//reference variable

    @PutMapping("/products/{id}/upload")
    public ResponseEntity<?>upload(@PathVariable Integer id,@RequestParam("file")MultipartFile file){
        return ResponseEntity.ok(productService.storeFile(id, file));
    }
         @GetMapping("/products/download/{filename}")
         public ResponseEntity<?> download(@PathVariable String filename){
            Resource resource = this.productService.downloadFile(filename);

            return  ResponseEntity.ok()
                                      .header (org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
                                       "attachment; filename=\"" + filename + "\"")
                                        .body(resource);
         }



//    // @RequestMapping(path = "/products",method = RequestMethod.GET)//this /products url for GET requets only
//    @GetMapping("/products")
//    public ResponseEntity<?> getAllProducts(){
//     //public Collection<product> getAllProducts(){
//         //return ProductService.getproducts();
//         return ResponseEntity.ok(ProductService.getproducts());

//     }
     
//     //here the request is coming from the JSON data                           //POST ONLY CREATE
//     //which we will read as athe parameter of the mapped method.
//    // @RequestMapping(path = "/products",method = RequestMethod.POST)//this /products url for post request only.
//    @PostMapping("/products")
//     //@requestbody annotation will read the json data from the request
//     //and convert into object of the class indicated in the method parameter.
//     //automatically call to setter method.from product,java class.
//    // public String addProduct(@RequestBody @Valid product p){
//     public ResponseEntity<?> addProduct(@RequestBody @Valid product p){
//         //return ProductService.add(p);
//         return ResponseEntity.status(HttpStatus.CREATED).body(ProductService.add(p));

//     }

                                          //{id is variable}     //GET BY ID
//    // @RequestMapping(path = "/products/{id}",method = RequestMethod.GET) instead of this we are using @getmapping
//    @GetMapping("/products/{id}")
//     //@pathvariable annotation is used to map the value of the path variable in the url with the method parameter.
//    // public product getProduct(@PathVariable("id") Integer pid){
//     public ResponseEntity<?> getProduct(@PathVariable("id") Integer pid){
//         //return ProductService.getProductByID(pid);
//         product found = ProductService.getProductByID(pid);
//         if(found== null){
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with this Id does not exist");
            
//         }
//         else{
//             return ResponseEntity.ok(found);
//         }

//     }
                                                                                 //DELETE BY ID
//    // @RequestMapping(path = "/products/{id}",method = RequestMethod.DELETE)
//    @DeleteMapping("/products/{id}")
//    // public String delete(@PathVariable Integer id){
//     public ResponseEntity<?> delete(@PathVariable Integer id){
//         //return ProductService.deleteProduct(id);
//          product found = ProductService.getProductByID(id);
//         if(found== null){
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with this ID does not exist");
            
//         }
//         else{
//             return ResponseEntity.ok(ProductService.deleteProduct(id));
//         }
//      }
    
//    // @RequestMapping(path = "/products/{id}",method = RequestMethod.PUT)          //PUT MAPPING UPDATE.
//    @PutMapping("/products/{id}")
//    // public String update(@PathVariable Integer id, @RequestBody product p){
//     public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody product p){
//         //return ProductService.updateProduct(id,p);
//          product found = ProductService.getProductByID(id);
//         if(found== null){
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with this ID does not exist");
            
//         }
//         else{
//             p.setCreationTime(found.getCreationTime());
//             return ResponseEntity.ok(ProductService.updateProduct(id,p));
//         }

//     }
    
}

