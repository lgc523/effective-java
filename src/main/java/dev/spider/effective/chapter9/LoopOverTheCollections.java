package dev.spider.effective.chapter9;

import java.util.*;

//for-each 优于 for
public class LoopOverTheCollections {
    public static void main(String[] args) {
        deepLoop();
    }

    void iterator() {
        List<String> spider = Arrays.asList("spider", "2022-3-1");
        for (Iterator<String> i = spider.iterator(); i.hasNext(); ) {
            String _ = i.next();
            //...
        }
        Object[] array = spider.toArray();
        for (int i = 0; i < array.length; i++) {
            //
        }
        //preferred idiom for iterating over collections and arrays
        for (String s : spider) {
            //不涉及没有用的索引变量
            //不涉及可能的类型转换
        }
    }

    static void deepLoop() {
        List<Suit> suits = Arrays.asList(Suit.values());
        List<Rank> ranks = Arrays.asList(Rank.values());

        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            //NoSuchElementException
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                deck.add(new Card(i.next(), j.next()));
            }
        }
    }
}

enum Suit {
    CLUB, DIAMOND, HEART, SPADE
}

enum Rank {
    ACE, DEUCE, THREE, FOUR, FIE
}

class Card {
    private Suit left;
    private Rank right;

    public Card(Suit left, Rank right) {
        this.left = left;
        this.right = right;
    }

    public Suit getLeft() {
        return left;
    }

    public void setLeft(Suit left) {
        this.left = left;
    }

    public Rank getRight() {
        return right;
    }

    public void setRight(Rank right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return left == card.left && right == card.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

