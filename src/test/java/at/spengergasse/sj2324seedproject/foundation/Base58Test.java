package at.spengergasse.sj2324seedproject.foundation;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan(basePackages = "at.spengergasse.sj2324seedproject.foundation")
class Base58Test{
    //
    //    @Autowired
    //    private Base58 base58 = new Base58("Stor-", 9);


    //     this.base58 = new Base58("Stor-", 5);
    //    Base58Test(Base58 base58){
    //        this.base58 = new Base58("Stor-", 5);
    //    }

    @Before
    public void testSetup(){
        final Base58 base58;
    }

    @Test
    void testEnsureB(){
        //        String code = base58.getCodeCrea();
        //        System.out.println(code);

    }

}