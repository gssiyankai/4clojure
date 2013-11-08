(ns tic_tac_toe)

(defn winner [[x y z :as grid-by-lines]]
  (let [column (fn [f] (map f grid-by-lines))
        grid-by-columns (map column (list first second last))
        diagonal (fn [grid] (map #(%1 %2) (list first second last) grid))
        diagonals (map diagonal (list grid-by-lines (reverse grid-by-lines)))
        is-every (fn [symbol a] (every? #(= symbol %) a))
        is-winner (fn [user] (some #(is-every user %) (concat grid-by-lines grid-by-columns diagonals)))]
    (cond
      (is-winner :x) :x
      (is-winner :o) :o
      :else nil
      )
    )
  )

(defn solve [player grid]
  nil)