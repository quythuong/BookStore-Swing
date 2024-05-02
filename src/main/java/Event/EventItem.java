
package Event;

import com.nhom08.bookstore.Models.BookModel;
import java.awt.Component;

/**
 *
 * @author Quoc Thinh
 */
public interface EventItem {
    public void itemClick(Component com, BookModel item);
}
