(ns game_of_life)

(use 'clojure.set)

(defn next-generation [board]
  (let [offsets (clojure.set/difference (set (for [x (range -1 2) y (range -1 2)] (vector x y))) #{[0 0]})
        height (count board)
        width (count (first board))
        cell (fn [x y] (get-in board [x y] \space))
        neighbours (fn [x y] (map (fn [[dx dy]] (cell (+ x dx) (+ y dy))) offsets))
        living-neighbours (fn [x y] (count ((group-by identity (neighbours x y)) \#)))
        next-cell (fn [x y] (if (= (cell x y) \#)
                                (if (or (= (living-neighbours x y) 2) (= (living-neighbours x y) 3))
                                  \#
                                  \space)
                                (if (= (living-neighbours x y) 3)
                                  \#
                                  \space)
                            ))]
    (map #(apply str %)
      (partition width
        (for [x (range width) y (range height)]
          (next-cell x y)
        )
      )
    )
  )
)
