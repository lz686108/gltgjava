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
public class VueglShigongguankong implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 日期
     */
    private String rdate;

    /**
     * 步骤
     */
    private String buzhou;

    /**
     * 标准
     */
    private String biaozhun;

    /**
     * 用时
     */
    private String yongshi;

    /**
     * 施工关键点
     */
    private String sggjd;

    /**
     * 存档照片
     */
    private String cundangzhaopian;

    /**
     * 关键施工尺寸
     */
    private String gjsscc;

    /**
     * 人员
     */
    private String ssjsrenyuan;

    /**
     * 高炉跟踪人员
     */
    private String gaohugenzong;

    /**
     * 施工异常记录
     */
    private String shigongyichangjilu;

    /**
     * 人工维护日期
     */
    private String lurudate;

    /**
     * 高炉炉号
     */
    private String luhao;


}
