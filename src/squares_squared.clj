(ns squares_squared)

(defn square [x]
  (* x x)
)

(defn squares [start end]
  (when (<= start end)
    (cons start (lazy-seq (squares (square start) end)))
  )
)

(defn tokenize [squares]
  (let [digits (mapcat str squares)
        size (count digits)
        dim (first (drop-while #(< (* % %) size) (range)))]
    (concat digits (repeat (- (square dim) size) \*))
  )
)

(defn transform
  ([start end]
    (let [squares (squares start end)
          tokens (tokenize squares)
          nb-tokens (count tokens)
          length (dec (* 2 (int (Math/sqrt nb-tokens))))
          board (mapv (fn [y] (mapv (fn [x] \space) (range length))) (range length))
          position [(dec (int (Math/ceil (/ length 2))))
                    (if (odd? nb-tokens)
                      (dec length)
                      0)]]
      (->> (transform board length position nil (reverse tokens))
           (map #(apply str %)))
    )
  )
  ([board length position delta tokens]
    (if (not-empty tokens)
      (let [next-board (assoc-in board position (first tokens))
            next-delta (cond
                         (zero? (first position)) [1 -1]
                         (zero? (second position)) [1 1]
                         (= (dec length) (first position)) [-1 1]
                         (= (dec length) (second position)) [-1 -1]
                         :else delta)
            next-position (mapv + position next-delta)
            next-unvisited-position (if (= \space (get-in board next-position))
                                      next-position
                                      (mapv + position (case next-delta
                                                        [1 -1] [1 1]
                                                        [1 1] [-1 1]
                                                        [-1 1] [-1 -1]
                                                        [-1 -1] [1 -1])))]
        (transform next-board length next-unvisited-position (mapv - next-unvisited-position position) (rest tokens))
      )
      board)
  )
)
