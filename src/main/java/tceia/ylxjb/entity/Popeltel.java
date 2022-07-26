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
public class Popeltel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 点位
     */
    private String dianwei;

    /**
     * 时间
     */
    private String shijian;

    /**
     * 污染物
     */
    private String wuranwu;

    /**
     * 数据
     */
    private String shuju;

    /**
     * 区域
     */
    private String quyu;

    private String fid;

    private String xid;


}
