package org.fluentlenium.core.action;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.filter.Filter;
import org.fluentlenium.core.search.SearchControl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;

public class FillSelect extends AbstractFill {
    public FillSelect(SearchControl<? extends FluentWebElement> search, String cssSelector, Filter... filters) {
        super(search, cssSelector, filters);
    }

    public FillSelect(SearchControl<? extends FluentWebElement> search, By bySelector, Filter... filters) {
        super(search, bySelector, filters);
    }

    public FillSelect(SearchControl<? extends FluentWebElement> search, Filter... filters) {
        super(search, filters);
    }

    public FillSelect(FluentList<FluentWebElement> list, Filter... filters) {
        super(list, filters);
    }

    public FillSelect(FluentWebElement element, Filter... filters) {
        super(element, filters);
    }

    @Override
    protected FluentList<FluentWebElement> findElements() {
        FluentList<FluentWebElement> elements = super.findElements();
        Iterator<FluentWebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            FluentWebElement next = iterator.next();
            if (next.getTagName() == null || !next.getTagName().equalsIgnoreCase("select")) {
                iterator.remove();
            }
        }
        return elements;
    }

    /**
     * Select all options that have a value matching the argument for the Select element.
     *
     * @param value the select matching string
     * @return fill select constructor
     */
    public FillSelect withValue(String value) {
        FluentList<FluentWebElement> elements = findElements();

        if (elements.size() == 0) {
            throw new NoSuchElementException("No select element found");
        }

        for (FluentWebElement element : elements) {
            Select select = new Select(element.getElement());
            select.selectByValue(value);
        }
        return this;
    }

    /**
     * Select the option by its index for the Select element.
     *
     * @param index the select index value
     * @return fill select constructor
     */
    public FillSelect withIndex(int index) {
        boolean noSuchElement = true;
        for (FluentWebElement element : findElements()) {
            Select select = new Select(element.getElement());
            try {
                select.selectByIndex(index);
                noSuchElement = false;
            } catch (NoSuchElementException e) {
            }
        }

        if (noSuchElement) {
            throw new NoSuchElementException("No select element found with option index=" + index);
        }

        return this;
    }

    /**
     * Select all options that display text matching the argument for the Select element.
     *
     * @param text the select string part
     * @return fill select constructor
     */
    public FillSelect withText(String text) {
        FluentList<FluentWebElement> elements = findElements();

        if (elements.size() == 0) {
            throw new NoSuchElementException("No select element found");
        }


        for (FluentWebElement element : elements) {
            Select select = new Select(element.getElement());
            select.selectByVisibleText(text);
        }

        return this;
    }
}
