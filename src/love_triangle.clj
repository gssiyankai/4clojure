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

(defn triangle [bitmap height width surface x y dx dy]
  (let [x2 (+ x dx)
        y2 (+ y dy)]
    (if (and (< x2 width)
             (< y2 height)
             (every? #(= 1 %)
               (for [delta (range dx)]
                 (get-in bitmap [(- y2 delta) (+ x delta)])
               )
             ))
      (triangle bitmap height width (+ surface (inc dx)) x y (inc dx) (inc dy))
      surface
    )
  )
)

(defn area [[& mine]]
  (let [bitmap (apply to-binary mine)
        height (count bitmap)
        width (count (first bitmap))]
    (apply max
      (for [x (range height)
            y (range width)]
        (triangle bitmap height width 1 x y 1 -1)
      )
    )
  )
)
