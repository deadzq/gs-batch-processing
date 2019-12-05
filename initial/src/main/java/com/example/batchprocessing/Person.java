package com.example.batchprocessing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 现在您可以看到数据输入和输出的格式，您可以编写代码来表示一行数据，
 * 如下面的示例(来自src/main/java/com/ example/batchprocessing/person.java)所示
 * Now that you can see the format of data inputs and outputs,
 * you can write code to represent a row of data,
 * as the following example shows:
 *
 * You can instantiate the Person class either with first and
 * last name through a constructor or by setting the properties.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String lastName;
    private String firstName;

}
