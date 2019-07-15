package generator.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageDataModel {

    //包名
    private String packageName;

    //文件后缀
    private String fileSuffix;

    //模板名称
    private String templateName;

    public String getTemplateName() {
        return fileSuffix+".ftl";
    }

    public PackageDataModel(String packageName, String fileSuffix) {
        this.packageName = packageName;
        this.fileSuffix = fileSuffix;
    }
}
