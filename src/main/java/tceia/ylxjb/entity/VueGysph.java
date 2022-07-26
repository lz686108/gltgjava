package tceia.ylxjb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhen
 * @since 2022-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VueGysph implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 得分
     */
    private String defen1;

    /**
     * 说明
     */
    private String shuoming1;

    /**
     * 炉号
     */
    private String luhao;

    /**
     * 供应商名称
     */
    private String csnamers;

    /**
     * 耐材料名称
     */
    private String ncnamers;

    /**
     * 得分
     */
    private String defen2;

    /**
     * 得分
     */
    private String defen3;

    /**
     * 得分
     */
    private String defen4;

    /**
     * 得分
     */
    private String defen5;

    /**
     * 得分
     */
    private String defen6;

    /**
     * 得分
     */
    private String defen7;

    /**
     * 得分
     */
    private String defen8;

    /**
     * 得分
     */
    private String defen9;

    /**
     * 得分
     */
    private String defen10;

    /**
     * 得分
     */
    private String defen11;

    /**
     * 得分
     */
    private String defen12;

    /**
     * 得分
     */
    private String defen13;

    /**
     * 得分
     */
    private String defen14;

    /**
     * 储存日期
     */
    private String crdate;

    /**
     * 说明
     */
    private String shuoming2;

    /**
     * 说明
     */
    private String shuoming3;

    /**
     * 说明
     */
    private String shuoming4;

    /**
     * 说明
     */
    private String shuoming5;

    /**
     * 说明
     */
    private String shuoming6;

    /**
     * 说明
     */
    private String shuoming7;

    /**
     * 说明
     */
    private String shuoming8;

    /**
     * 说明
     */
    private String shuoming9;

    /**
     * 说明
     */
    private String shuoming10;

    /**
     * 说明
     */
    private String shuoming11;

    /**
     * 说明
     */
    private String shuoming12;

    /**
     * 说明
     */
    private String shuoming13;

    /**
     * 说明
     */
    private String shuoming14;


}
