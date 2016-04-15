#

SOURCES=spec.tex \
        styles/jsr.sty \
        styles/jsrfrontstyle.tex \
        styles/jsrmainstyle.tex \
        styles/lineno.sty \
        styles/macros.tex \
        styles/ntheorem.sty \
        chapters/titlepage.tex \
        chapters/license.tex \
        chapters/intro.tex \
        chapters/controllers.tex \
        chapters/validation.tex \
        chapters/security.tex \
        chapters/events.tex \
        chapters/applications.tex \
        chapters/engines.tex \
        chapters/annotations.tex \
        chapters/changes.tex \
        chapters/assertions.tex \
        chapters/refs.tex \
        references.bib

all: spec.pdf

spec.pdf: ${SOURCES}
	pdflatex spec.tex
	bibtex spec.aux
	pdflatex spec.tex
	pdflatex spec.tex

clean:
	rm -f spec.aux spec.bbl spec.blg spec.log spec.out spec.pdf spec.thm spec.toc
	rm -f chapters/*.aux styles/*.aux
