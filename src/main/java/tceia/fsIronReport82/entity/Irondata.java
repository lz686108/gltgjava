package tceia.fsIronReport82.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * @since 2022-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ironData")
public class Irondata implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String weightNo;

    private String tankNo;

    private String furnaceDegree;

    private String weighterId;

    private LocalDate weightDate1;

    private String weightDate2;

    private String grossWeight;

    private String tareWeight;

    private String consignUnit;

    private String receveUnit;

    private String pure;

    private String grossWeightDate;

    private String grossWeightTime;

    private String tareWeightDate;

    private String tareWeightTime;

    private String item;

    private String weightHourse1;


}
