(ns love_triangle)

(defn to-binary [& ns]
  (let [convert (fn convert [n]
                  (when-not (zero? n)
                    (cons (bit-and n 1) (lazy-seq (convert (bit-shift-right n 1))))))
        bs (map #(reverse (convert %)) ns)
        max-bitmap-size (reduce #(max %1 (count %2)) 0 bs)
        pad (fn [bitmap p]
              (concat (repeat (- p (count bitmap)) 0) bitmap))]
    (vec (map #(vec (pad % max-bitmap-size)) bs))
  )
)

(defn mineral? [bitmap x y]
  (= 1 (get-in bitmap [y x]))
)

(defn within-bounds? [height width x y]
  (and (>= x 0)
       (>= y 0)
       (< x width)
       (< y height))
)

(defn triangle1
  ([bitmap height width surface x y]
    (triangle1 bitmap height width surface x y -1 -1)
  )
  ([bitmap height width surface x y dx dy]
    (let [x2 (+ x dx)
          y2 (+ y dy)]
      (if (and (within-bounds? height width x2 y2)
               (every? true?
                 (for [delta (range (inc (Math/abs dx)))]
                   (mineral? bitmap (- x delta) (+ y2 delta))
                 )
               ))
        (triangle1 bitmap height width (+ surface (inc (Math/abs dx))) x y (dec dx) (dec dy))
        surface
      )
    )
  )
)

(defn triangle2
  ([bitmap height width surface x y]
    (triangle2 bitmap height width surface x y 1 -1)
  )
  ([bitmap height width surface x y dx dy]
    (let [x1 (- x dx)
          x2 (+ x dx)
          y2 (+ y dy)]
      (if (and (within-bounds? height width x1 y2)
               (within-bounds? height width x2 y2)
               (every? true?
                 (for [delta (range (inc dx))]
                   (mineral? bitmap (+ x1 delta) y2)
                 )
               ))
        (triangle2 bitmap height width (+ surface (inc (* dx 2))) x y (inc dx) (dec dy))
        surface
      )
    )
  )
)

(defn triangle3
  ([bitmap height width surface x y]
    (triangle3 bitmap height width surface x y 1 1)
  )
  ([bitmap height width surface x y dx dy]
    (let [x2 (+ x dx)
          y1 (- y dy)
          y2 (+ y dy)]
      (if (and (within-bounds? height width x2 y1)
               (within-bounds? height width x2 y2)
               (every? true?
                 (for [delta (range (inc dy))]
                   (mineral? bitmap x2 (+ y1 delta))
                 )
               ))
        (triangle3 bitmap height width (+ surface (inc (* dy 2))) x y (inc dx) (inc dy))
        surface
      )
    )
  )
)

(defn area [[& mine]]
  (let [bitmap (apply to-binary mine)
        height (count bitmap)
        width (count (first bitmap))
        max-area (->> (map #(for [x (range width)
                                  y (range height)
                                 :when (mineral? bitmap x y)]
                              (% bitmap height width 1 x y)
                            )
                           [triangle1 triangle2 triangle3])
                      (flatten)
                      (apply max)
                 )]
    (when (not= 1 max-area)
      max-area
    )
  )
)
