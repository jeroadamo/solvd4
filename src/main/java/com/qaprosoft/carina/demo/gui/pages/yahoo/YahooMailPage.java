package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooMailPage extends AbstractPage {
    @FindBy(css = "a.e_dRA.l_T.cn_dBP.cg_FJ.k_w.r_P.A_6EqO.u_e69.p_R.S_n.C_ZkbNhI.I_ZamTeg.D_F.H_6VdP.gl_C.ab_C.en_0.M_1Eu7sD.it_dRA.is_1SUcgJ.cZdTOHS_28Otf4")
    private ExtendedWebElement compose;


    public YahooMailPage(WebDriver driver) {
        super(driver);
    }
}
