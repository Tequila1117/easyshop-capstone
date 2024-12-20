# EASY SHOP Capstone

## Summary

EASY SHOP is a website where users can search products, add them to a shopping cart, and check out. Version 1 of the website is fully functional on the front end, and my task was to fix some bugs and implement missing backend functionality in the Spring Boot Java API.

## Features

The backend API includes:

- User registration and login 
- Displaying products by category
- Search and filtering of products

## Bugs 

- **Search/Filter Bug:** The search and filter features were returning incorrect results.
- **Product Duplication Bug:** Products were being duplicated when administrators tried to update them.

## Phase 1: CategoriesController Implementation



I implemented the missing methods in the CategoriesController class, which had been created but not yet functional. I added the necessary annotations and called the methods to handle category functions.

Ex: Only users with the ADMIN role are allowed to perform actions like adding, updating, or deleting categories.

![UPDATEandDELETE.PNG](..%2FUsers%2FStudent%2FPictures%2FUPDATEandDELETE.PNG)
![callmethods.PNG](..%2FUsers%2FStudent%2FPictures%2Fcallmethods.PNG)
Changes:
- Implemented methods for CRUD operations (Create, Read, Update, Delete) for categories.

- Ensured that only ADMIN users can use features that update/delete the categories.
Used MySqlCategoriesDao for database operations and followed the Category model.


# Phase 2: Bug Fixes

I fixed two  bugs with the products functionality. There was a search/filter issue and a product duplication problem.

## 1. Search Bug Fix:

   Users had reported that the product search functionality was returning incorrect results, especially when filtering by category or price range. The max parameter needed to be added.
![Product bug.PNG](..%2FUsers%2FStudent%2FPictures%2FProduct%20bug.PNG)

Fix Details:
The search URL accepts query parameters for category, color, and price range:

![ProductSearch.PNG](..%2FUsers%2FStudent%2FPictures%2FProductSearch.PNG)



I updated the search logic to correctly filter products based on the provided criteria, ensuring accurate and relevant results.

## 2. Product Duplication Bug Fix:

   Another reported issue was product duplication during updates. When administrators attempted to update a product, a new record was being created in the database instead of modifying the existing one. I identified the issue and fixed it.

**Fix Details:**

- When an users update a product, the correct product is updated. This prevents duplicates in the database and ensures that the existing product’s details (like price, description, etc.) are correctly updated.
Development Notes
I focused on implementing backend functionality using Spring Boot.
Ensured that only ADMIN users have permission to create/delete products and categories.



## Testing

- I tested all functionality using java script to ensure the results were passed.



![PASStest1.PNG](..%2FUsers%2FStudent%2FPictures%2FPASStest1.PNG)
![PASStest2.PNG](..%2FUsers%2FStudent%2FPictures%2FPASStest2.PNG)