# Internet Shop

## The app defines following CRUD APIs
**Category**
```
GET /category/{id} // get category by id
PUT /category/{id} // change category by id
POST /category // craete category
DELETE /category/{id} // delete category by id
GET /category // get all categories
```

**Image**
```
GET /image/{id} // get image by id
POST /image // create image
PUT /image/{id} // change image by id
DELETE /image/{id} // delete image by id
GET /image // get all imagies
```

**Login**
```
POST /login // authentication
```

**Order**
```
GET /order/{id} // get order by id
POST /order // craete order
DELETE /order/{id} // delete order by id
GET /order // get all orders
GET /order/user/{mail} // get all orders of user by mail
```

**Product**
```
GET /product/{id} get product by id
PUT /product/{id} change product by id
POST /product // create product by id
DELETE /product/{id} // delete product by id
GET /product // get all products
GET /product/{low}/{high} // get product by price
GET /product/{text} // get product by name
GET /product/subcategory/{id} // get product by subcategory id
GET /product/tag/{id} // get product by tag id
```

**Subcategory*
```
GET /subcategory/{id} // get subcategory by id
PUT /subcategory/{id} // change subcategory by id
POST /subcategory // create subcategory
DELETE /subcategory/{id} // delete subcategory by id
GET /subcategory // get all subcategories
```

**Tag**
```
GET /tag/{id} // get tag by id
PUT /tag/{id} // change tag by id
POST /tag // create tag
DELETE /tag/{id} // delete tag by id
GET /tag // get all tags
```

## Credentials for login
```
username - admin
password - admin
```

## Credentials for MySQL
You have to change credentials in ```application.properties``` to able the app to connect to your MySQL
```
spring.datasource.username= yourUsername
spring.datasource.password= yourPassword
```
