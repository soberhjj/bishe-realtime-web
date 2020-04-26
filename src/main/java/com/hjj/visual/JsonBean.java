package com.hjj.visual;

import org.springframework.stereotype.Component;

/**
 * @author soberhjj  2020/4/26 - 10:59
 */
@Component
public class JsonBean {
    private Long donghua;
    private Long music;
    private Long dance;
    private Long technology;
    private Long life;
    private Long fasion;
    private Long ent;
    private Long cinema;

    public Long getDonghua() {
        return donghua;
    }

    public void setDonghua(Long donghua) {
        this.donghua = donghua;
    }

    public Long getMusic() {
        return music;
    }

    public void setMusic(Long music) {
        this.music = music;
    }

    public Long getDance() {
        return dance;
    }

    public void setDance(Long dance) {
        this.dance = dance;
    }

    public Long getTechnology() {
        return technology;
    }

    public void setTechnology(Long technology) {
        this.technology = technology;
    }

    public Long getLife() {
        return life;
    }

    public void setLife(Long life) {
        this.life = life;
    }

    public Long getFasion() {
        return fasion;
    }

    public void setFasion(Long fasion) {
        this.fasion = fasion;
    }

    public Long getEnt() {
        return ent;
    }

    public void setEnt(Long ent) {
        this.ent = ent;
    }

    public Long getCinema() {
        return cinema;
    }

    public void setCinema(Long cinema) {
        this.cinema = cinema;
    }

    public Long getAnime() {
        return anime;
    }

    public void setAnime(Long anime) {
        this.anime = anime;
    }

    public Long getGuochuang() {
        return guochuang;
    }

    public void setGuochuang(Long guochuang) {
        this.guochuang = guochuang;
    }

    public Long getGame() {
        return game;
    }

    public void setGame(Long game) {
        this.game = game;
    }

    public Long getDigital() {
        return digital;
    }

    public void setDigital(Long digital) {
        this.digital = digital;
    }

    private Long anime;
    private Long guochuang;
    private Long game;
    private Long digital;
}
