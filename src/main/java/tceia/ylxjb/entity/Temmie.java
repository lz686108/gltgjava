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
public class Temmie implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String a0;

    private String b1;

    private String c2;

    private String d3;

    private String e4;

    private String f5;

    private String g6;

    private String h7;

    private String i8;

    private String j9;

    private String k10;

    private String l11;

    private String m12;

    private String n13;

    private String o14;

    private String p15;

    private String q16;

    private String r17;

    private String s18;

    private String t19;

    private String u20;

    private String v21;

    private String w22;

    private String x23;

    private String luhao;

    private String weizhi;

    private String riqidate;

    /**
     * 渣线铁线
     */
    private String ztx;


}
