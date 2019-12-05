package com.example.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * PersonItemProcessor implements Spring Batch's ItemProcessor(项目处理器)interface.
 * This makes it easy to wire the code into a batch job that you will define later in this guide.
 * According to the interface, you receive(接收) an incoming Person object,
 * after which you transform it to an upper-cased Person.(然后将其转换成大写的人 ^_^)
 */
//人类中间处理机
public class PersonItemProcessor implements ItemProcessor<Person,Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName,lastName);

        log.info("Converting("+person+")info("+transformedPerson+")");

        return transformedPerson;
    }
}
