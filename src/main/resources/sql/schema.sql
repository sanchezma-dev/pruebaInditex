CREATE TABLE brand
  (
     brand_id   INT PRIMARY KEY,
     name VARCHAR(100) NOT NULL
  );

CREATE TABLE prices
  (
     price_id   BIGINT auto_increment PRIMARY KEY,
     brand_id   INT,
     start_date TIMESTAMP,
     end_date   TIMESTAMP,
     price_list INT,
     product_id INT,
     priority   INT,
     price      DECIMAL(10, 2),
     curr       VARCHAR(3),
     FOREIGN KEY (brand_id) REFERENCES brand(brand_id)
  );
