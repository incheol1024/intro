package me.about.intro.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HOME_TBL")
public class Home {


    @Id
    @Column(name = "HOME_TITLE")
    String homeTitle;

    @Column(name = "HOME_DESCR")
    String homeDescr;


    public String getHomeTitle() {
        return homeTitle;
    }

    public void setHomeTitle(String homeTitle) {
        this.homeTitle = homeTitle;
    }

    public String getHomeDescr() {
        return homeDescr;
    }

    public void setHomeDescr(String homeDescr) {
        this.homeDescr = homeDescr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(homeTitle, home.homeTitle) &&
                Objects.equals(homeDescr, home.homeDescr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTitle, homeDescr);
    }
}
