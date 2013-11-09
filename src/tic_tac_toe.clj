(ns tic_tac_toe)

(defn winner [grid-by-lines]
  (let [column (fn [f] (map f grid-by-lines))
        grid-by-columns (map column [first second last])
        diagonal (fn [grid] (map #(%1 %2) [first second last] grid))
        diagonals (map diagonal [grid-by-lines (reverse grid-by-lines)])
        is-every (fn [symbol coll] (every? #(= symbol %) coll))
        is-winner (fn [player] (some #(is-every player %) (concat grid-by-lines grid-by-columns diagonals)))]
    (cond
      (is-winner :x) :x
      (is-winner :o) :o
      :else nil
      )
    )
  )

(defn solve [player grid]
  (let [positions (reduce (fn [acc-x pos-x] (concat acc-x (reduce (fn [acc-y pos-y] (conj acc-y [pos-x pos-y])) () (range 3)))) () (range 3))
        is-empty (fn [x y] (= :e ((grid x) y)))
        next-grid (fn [x y] (assoc grid x (assoc (grid x) y player)))
        is-winning-move (fn [[x y]] (and (is-empty x y) (= player (winner (next-grid x y)))))]
    (set (filter is-winning-move positions))
  )
)