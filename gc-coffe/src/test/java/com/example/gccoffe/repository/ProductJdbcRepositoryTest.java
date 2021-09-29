package com.example.gccoffe.repository;

import com.example.gccoffe.product.model.Category;
import com.example.gccoffe.product.model.Product;
import com.example.gccoffe.product.repository.ProductRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.UUID;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;

// AsertThat 사용
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // TEST Instance를 클래스 단위마다 실행
// resources에 application.yaml 정보를 읽기위해 사용
//@ActiveProfiles("test")
class ProductJdbcRepositoryTest {

    @Configuration
    @ComponentScan(basePackages = {"com.example.gccoffe.product.repository"})
    static class Config {

        @Bean
        public DataSource dataSource() {


            var dataSource= DataSourceBuilder.create()
                    .url("jdbc:mysql://localhost/order_mgmt_test")
                    .username("root")
                    .password("root1234!")
                    .type(HikariDataSource.class)
                    .build();


            dataSource.setMaximumPoolSize(1000);
            dataSource.setMinimumIdle(100);
            return dataSource;

        }

        @Bean
        public JdbcTemplate jdbcTemplate(DataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }


        @Bean
        public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate jdbcTemplate) {
            return new NamedParameterJdbcTemplate(jdbcTemplate);
        }

    }



    @Autowired
    ProductRepository repository;

    // 만들어진 빈 사용 (필드 주입) -> 위에서 생성되어진 빈이 들어감
    @Autowired
    DataSource dataSource;

    private final Product newProduct=new Product(UUID.randomUUID(),"new-product2", Category.COFFE_BEAN_PACKAGE,1000L);

    @Test
    @Order(1)
    @DisplayName("상품 추가")
    void testInsert() {
        repository.insert(newProduct);
        var all=repository.findAll();
        assertThat(all.isEmpty(),is(false));
    }

    @Test
    @Order(2)
    @DisplayName("상품을 이름으로 조회")
    void testFindByName() {
        var product=repository.findByName(newProduct.getProductName());
        assertThat(product.isEmpty(),is(false));
    }

    @Test
    @Order(3)
    @DisplayName("상품을 Id로 조회")
    void testFindById() {
        var product=repository.findById(newProduct.getProductId());
        assertThat(product.isEmpty(),is(false));
    }

    @Test
    @Order(4)
    @DisplayName("상품을 카테고리로 조회")
    void testFindByCategory() {
        var product=repository.findByCategory(Category.COFFE_BEAN_PACKAGE);
        assertThat(product.isEmpty(),is(false));
    }

    @Test
    @Order(5)
    @DisplayName("상품 수정")
    void testUpdate() {
        newProduct.setProductName("updated-product");
        repository.update(newProduct);

        var product=repository.findById(newProduct.getProductId());
        assertThat(product.isEmpty(),is(false));
        assertThat(product.get(),samePropertyValuesAs(newProduct));
    }

//    @Test
//    @Order(6)
//    @DisplayName("상품 전체 삭제")
//    void testDeleteAll() {
//        repository.deleteAll();
//        var all=repository.findAll();
//        assertThat(all.isEmpty(),is(true));
//    }





}