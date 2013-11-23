(ns analyze_reversi)

(defn coordinates [board player]
  (for [x (range (count board))
        y (range (count (first board)))
        :when (= player ((board x) y))]
    [x y]
  )
)

(defn opponent [player]
  (cond (= player 'w) 'b
        (= player 'b) 'w)
)

(defn moves
  ([board player]
    (let [empty-coordinates (coordinates board 'e)
          opponent (opponent player)
          opponent-coordinates (set (coordinates board opponent))
          player-coordinates (set (coordinates board player))]
      (->>
            (apply merge (map #(hash-map % (for [f-x [inc identity dec]
                                                f-y [inc identity dec]]
                                            (moves player-coordinates opponent-coordinates % f-x f-y)))
                             empty-coordinates))
           (map (fn [entry] [(first entry) (filter #(> (count %) 1) (second entry))]))
           (map (fn [entry] [(first entry) (filter #(every? (fn [arg] (not (nil? arg))) %) (second entry))]))
           (map (fn [entry] [(first entry) (filter #(contains? player-coordinates (last %)) (second entry))]))
           (map (fn [entry] [(first entry) (filter #(vector? (first %)) (second entry))]))
           (map (fn [entry] [(first entry) (map #(drop-last %) (second entry))]))
           (filter (fn [entry] (not (empty? (second entry)))))
           (map (fn [entry] [(first entry) (apply set (second entry))]))
           (into {})
      )
    )
  )
  ([player-coordinates opponent-coordinates current-coordinates f-x f-y]
    (let [next-coordinates [(f-x (first current-coordinates))(f-y (second current-coordinates))]]
      (cond (contains? opponent-coordinates next-coordinates) (cons next-coordinates (moves player-coordinates opponent-coordinates next-coordinates f-x f-y))
            (contains? player-coordinates next-coordinates) [next-coordinates]
      )
    )
  )
)
