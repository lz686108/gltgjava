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
public class HbbzCopy1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 排放参数
     */
    private String pfcs;

    private String fid;

    private String xid;

    /**
     * 区域
     */
    private String quyu;

    /**
     * 点位
     */
    private String dianwei;

    /**
     * 污染物
     */
    private String wuranwu;

    private String ecope;

    private String sgsui;


}
