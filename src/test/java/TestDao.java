import cn.fundview.modules.dao.CompanyMapper;
import cn.fundview.modules.service.ConsultationService;
import cn.fundview.modules.service.PayRemittanceService;
import cn.fundview.modules.web.account.CompanyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager2")
public class TestDao {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private PayRemittanceService payRemittanceService;

    @Test
    public void test1() {

//        companyMapper.getList();
    }

    @Test
    public void test2() {

       // payRemittanceService.findByPayCode("FJFUSJ000001001");
    }
    @Test
    public void test3() {

//        System.out.println(companyMapper.countAllCompByArea());;
    }
}
