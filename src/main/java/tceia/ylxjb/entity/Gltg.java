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
public class Gltg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1号东
     */
    private String addx;

    private String adxx;

    private String axdx;

    private String axxx;

    private String bdx;

    private String bxx;

    private String cdx;

    private String cxx;

    private String ddx;

    private String dxx;

    private String edx;

    private String exx;

    private String gangodate;


}
