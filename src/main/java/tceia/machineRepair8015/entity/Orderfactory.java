package tceia.machineRepair8015.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhen
 * @since 2022-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("orderFactory")
public class Orderfactory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String factory;

    @TableField("factoryOrderId")
    private Integer factoryorderid;

    private String process;


}
