(ns tic_tac_toe)

(defn winner [[x y z :as grid-by-lines]]
  (let [column (fn [f] (map f grid-by-lines))
        grid-by-columns (map column [first second last])
        diagonal (fn [grid] (map #(%1 %2) [first second last] grid))
        diagonals (map diagonal [grid-by-lines (reverse grid-by-lines)])
        is-every (fn [symbol coll] (every? #(= symbol %) coll))
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