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
public class VueglGl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 炉号
     */
    private String lhnubm;

    /**
     * 版本号
     */
    private String bbh;

    /**
     * 厂家
     */
    private String changjia;

    /**
     * 料种
     */
    private String liaozhong;

    /**
     * 编号
     */
    private String bianhao;

    /**
     * 到货日期
     */
    private String dhdate;

    /**
     * 检验项目
     */
    private String jianyanxiangmu;

    /**
     * 技术标准
     */
    private String jishubiaozhun;

    /**
     * 检验结果
     */
    private String jianyanjieguo;

    /**
     * 结果判定
     */
    private String jieguopanding;

    /**
     * 检验机构
     */
    private String jianyanjigou;

    /**
     * 标准
     */
    private String biaozhun;

    /**
     * 实际
     */
    private String shiji;

    /**
     * 存放地点
     */
    private String cunfangdidian;

    /**
     * 存放条件
     */
    private String cunfangtiaojian;


}
