package guru.springframework.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    @Before
    public void setup() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long l = 4L;
        category.setId(l);
        assertEquals(l,category.getId());
    }
}
