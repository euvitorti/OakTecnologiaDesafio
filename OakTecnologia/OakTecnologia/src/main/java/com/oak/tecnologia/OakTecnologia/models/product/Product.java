    package com.oak.tecnologia.OakTecnologia.models.product;
    
    import com.oak.tecnologia.OakTecnologia.dto.product.ProductDTO;
    import jakarta.persistence.*;
    
    @Entity
    @Table(name = "products")
    public class Product {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(nullable = false, length = 100)
        private String productName;
    
        @Column(length = 255)
        private String productDescription;
    
        @Column(nullable = false)
        private Double productPrice;
    
        @Column(nullable = false)
        private Boolean availableForSale;
    
        // Constructors
        public Product() {
        }
    
        public Product(ProductDTO productDTO) {
            this.productName = productDTO.productName();
            this.productDescription = productDTO.productDescription();
            this.productPrice = productDTO.productPrice();
            this.availableForSale = productDTO.availableForSale();
        }
    
        // Getters and Setters
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getProductName() {
            return productName;
        }
    
        public void setProductName(String productName) {
            this.productName = productName;
        }
    
        public String getProductDescription() {
            return productDescription;
        }
    
        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }
    
        public Double getProductPrice() {
            return productPrice;
        }
    
        public void setProductPrice(Double productPrice) {
            this.productPrice = productPrice;
        }
    
        public Boolean getAvailableForSale() {
            return availableForSale;
        }
    
        public void setAvailableForSale(Boolean availableForSale) {
            this.availableForSale = availableForSale;
        }
    }
