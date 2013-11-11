(ns best_poker_hand)

(defn best-hand [hand]
  (let [hand-by-rank (group-by #(get % 1) hand)
        hand-by-suit (group-by #(get % 0) hand)
        number-of-pairs (reduce #(if (= (count (second %2)) 2) (+ %1 1) %1) 0 hand-by-rank)
        n-of-a-kind (fn [n] (some #(= (count (second %)) n) hand-by-rank))
        three-of-a-kind (n-of-a-kind 3)
        ranks (sort (map #({\2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9 \T 10 \J 11 \Q 12 \K 13 \A 0} (get % 1)) hand))
        straight (empty? (drop-while #(cond (and (zero? (first %)) (or (= 2 (second %)) (= 10 (second %)))) true
                                            (= (first %) (dec (second %))) true
                                            :else false
                                      ) (partition 2 1 ranks)))
        flush (= 5 (count (second (first hand-by-suit))))
        full-house (empty? (drop-while #(contains? #{2 3} (count (second %))) hand-by-rank))
        four-of-a-kind (n-of-a-kind 4)
        straight-flush (and straight flush)]
    (cond straight-flush :straight-flush
          four-of-a-kind :four-of-a-kind
          full-house :full-house
          flush :flush
          straight :straight
          three-of-a-kind :three-of-a-kind
          (= number-of-pairs 2) :two-pair
          (= number-of-pairs 1) :pair
          :else :high-card
    )
  )
)
